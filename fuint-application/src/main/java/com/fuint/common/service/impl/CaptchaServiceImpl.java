package com.fuint.common.service.impl;

import com.fuint.common.util.RedisUtil;
import com.fuint.common.service.CaptchaService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.fuint.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 图形验证码插件服务类
 *
 * Created by FSQ
 * CopyRight https://www.fuint.cn
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

    private static final Logger logger = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    @Resource
    private Producer captchaProducer;

    /**
     * 生成图形验证码,并保存至Session
     * @param session Session
     * @return BufferedImage
     */
    public BufferedImage getCode(HttpSession session){
        // 生成验证码
        String codeText = captchaProducer.createText();
        BufferedImage codeImage = captchaProducer.createImage(codeText);
        logger.info("生成验证码{}", codeText);

        // 设置Session信息
        if (session != null) {
            session.setAttribute(Constants.KAPTCHA_SESSION_KEY, codeText);
        }

        return codeImage;
    }

    /**
     * 图形验证码校验
     * @param code 输入的验证码
     * @param session Session
     * @return Boolean
     */
    public Boolean checkCode(String code, HttpSession session){
        String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtil.isEmpty(code) || StringUtil.isEmpty(sessionCode)) {
            return false;
        } else {
            if (code.equalsIgnoreCase(sessionCode)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 生成图形验证码
     * @return BufferedImage
     */
    public BufferedImage getCodeByUuid(String uuid) {
        // 生成验证码
        String codeText = captchaProducer.createText();
        BufferedImage codeImage = captchaProducer.createImage(codeText);
        logger.info("生成验证码{}", codeText);

        if (codeText != null) {
            RedisUtil.set(uuid, codeText, 1800);
        }

        return codeImage;
    }

    /**
     * 图形验证码校验
     * @param code 输入的验证码
     * @param uuid uuid
     * @return Boolean
     */
    public Boolean checkCodeByUuid(String code, String uuid){
        String vCode = RedisUtil.get(uuid);
        if (StringUtil.isEmpty(code) || StringUtil.isEmpty(vCode)) {
            return false;
        } else {
            if (code.equalsIgnoreCase(vCode)) {
                return true;
            } else {
                return false;
            }
        }
    }
}