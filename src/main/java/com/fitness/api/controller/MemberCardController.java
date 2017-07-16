package com.fitness.api.controller;

import com.fitness.annotations.OathAnnotation;
import com.fitness.api.domain.MemberCard;
import com.fitness.api.service.MemberCardService;
import com.fitness.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员卡-api
 * Created on 2017/7/2.
 */
@RestController
@RequestMapping("memberCard")
public class MemberCardController {

    @Autowired
    private MemberCardService memberCardService;

    /**
     * 新增会员卡
     *
     * @param memberCard
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(@RequestBody MemberCard memberCard) {
        return memberCardService.add(memberCard);
    }

    /**
     * 修改会员卡
     *
     * @param memberCard
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public BaseResult update(@RequestBody MemberCard memberCard) {
        return memberCardService.update(memberCard);
    }

    /**
     * 根据会员卡号查询会员卡列表  分页
     *
     * @param pageNo
     * @param pageSize
     * @param key
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public BaseResult list(Integer pageNo, Integer pageSize, String key) {
        return memberCardService.list(pageNo, pageSize, key);
    }

    /**
     * 根据会员卡id 删除会员卡
     *
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public BaseResult del(Long id) {
        return memberCardService.del(id);
    }

    /**
     * 根据会员卡id 查看会员卡详情
     *
     * @param id
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "/memberCardInfo", method = RequestMethod.GET)
    public BaseResult memberCardInfo(Long id) {
        return memberCardService.memberCardInfo(id);
    }

    /**
     * 根据场馆id 查询 所有会员卡列表
     *
     * @param stadiumId
     * @return
     */
    @OathAnnotation
    @RequestMapping(value = "cardList", method = RequestMethod.GET)
    public BaseResult cardList(Long stadiumId) {
        return memberCardService.cardList(stadiumId);
    }

}
