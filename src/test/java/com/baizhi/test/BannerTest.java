package com.baizhi.test;

import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BannerTest extends  BasicTest{
    @Autowired
        private BannerService bannerService;

    @Test
    public void testadd(){
        Banner banner=new Banner();
        banner.setTitle("111");
        banner.setImgpth("HHH");
        banner.setDescstr("SSS");
        banner.setStatus(1);
        banner.setDate(new Date());
        bannerService.add(banner);
    }
    @Test
    public void updateTest(){
        Banner banner=new Banner();
        banner.setId(1);
        banner.setTitle("111");
        banner.setImgpth("111");
        banner.setDescstr("111");
        banner.setStatus(1);
        banner.setDate(new Date());
        bannerService.motify(banner);
    }
    @Test
    public void testFind(){
        List<Banner> bs = bannerService.findByPage(1, 2);
        for (Banner emp : bs) {
            System.out.println(emp);
        }
    }

    @Test
    public void testFindTotals(){
        Long totals = bannerService.findTotals();
        System.out.println(totals);
    }

    @Test
    public void testqueryone(){
        System.out.println(bannerService.fiandOne(1));
    }


    @Test
    public void testDelete(){
        bannerService.remove(1);
    }

}
