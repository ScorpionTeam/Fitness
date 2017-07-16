package com.fitness.api.controller;

import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.Member;
import com.fitness.api.service.MemberService;
import com.fitness.result.BaseResult;
import com.fitness.result.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员-api
 * Created on 2017/7/1.
 */
@RestController
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public BaseResult login(String phone, String password) throws Exception {
        return memberService.login(phone, password);
    }

    /**
     * 注册
     *
     * @param member
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResult register(@RequestBody Member member) throws Exception {
        return memberService.register(member);
    }


    /**
     * 昵称修改
     *
     * @param id
     * @param nick
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/updateNick", method = RequestMethod.POST)
    public BaseResult updateNick(Long id, String nick) {
        return memberService.updateNick(id, nick);
    }

    /**
     * 退出
     *
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public BaseResult logout(Long id) {
        return memberService.logout(id);
    }

    /**
     * 基本信息修改
     *
     * @param member
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody Member member) {
        return memberService.update(member);
    }

    /**
     * 根据会员id  查询会员详情
     *
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
    public BaseResult memberInfo(Long id) {
        return memberService.memberInfo(id);
    }

    /**
     * 绑定会员卡
     *
     * @param member
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/bindCard", method = RequestMethod.POST)
    public BaseResult bindCard(@RequestBody Member member) {
        return memberService.bindCard(member);
    }

    /**
     * 根据会员id 注销会员
     *
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public BaseResult cancel(Long id) {
        return memberService.cancel(id);
    }

    /**
     * 根据会员手机号查找会员信息   分页
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageResult list(Integer pageNo, Integer pageSize, String key) {
        return memberService.list(pageNo, pageSize, key);
    }

}
