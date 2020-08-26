package com.pw.controller;

import com.pw.pojo.*;
import com.pw.pojo.utils.PicturePage;
import com.pw.service.*;
import com.pw.utils.DownloadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(value = "首页接口层次", tags = "首页接口")
@Controller
@Slf4j
@RequestMapping("/main")
public class MainController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private AccountFeedbackService accountFeedbackService;
    @Autowired
    private AccountCollectionService accountCollectionService;
    @Autowired
    private AccountDownloadService accountDownloadService;
    @Autowired
    private PageViewsService pageViewsService;


    @RequestMapping("/rotation")
    @ApiOperation("跳转到首页")
    public String rotation(Model model, HttpSession httpSession) {
        //清除页数
        if (httpSession.getAttribute("PicturePage") != null) {
            httpSession.removeAttribute("PicturePage");
        }
        PicturePage picturePage = new PicturePage();
        picturePage.setBigSort("轮播图");
        List<Picture> pictureRotation = pictureService.findPicture(picturePage);
        List<Picture> pictureRotation1 = new ArrayList<Picture>();
        pictureRotation1.add(pictureRotation.get(0));
        List<Picture> pictureRotation2 = new ArrayList<Picture>();
        pictureRotation2.add(pictureRotation.get(1));
        List<Picture> pictureRotation3 = new ArrayList<Picture>();
        pictureRotation3.add(pictureRotation.get(2));
        List<Picture> pictureRotation4 = new ArrayList<Picture>();
        pictureRotation4.add(pictureRotation.get(3));
        List<Picture> pictureRotation5 = new ArrayList<Picture>();
        pictureRotation5.add(pictureRotation.get(4));

        picturePage.setBigSort("新冠肺炎");
        List<Picture> xgfy = pictureService.findPicture(picturePage);

        picturePage.setBigSort("异国动物");
        List<Picture> ygdw = pictureService.findPicture(picturePage);

        picturePage.setBigSort("旅行风景");
        List<Picture> lxfj = pictureService.findPicture(picturePage);

        picturePage.setBigSort("激情竞技");
        List<Picture> jqjj = pictureService.findPicture(picturePage);

        picturePage.setBigSort("图片专辑");
        List<Picture> tpzj = pictureService.findPicture(picturePage);

        picturePage.setBigSort("文字图片");
        List<Picture> wztp = pictureService.findPicture(picturePage);

        picturePage.setBigSort("首页底部");
        List<Picture> sydb = pictureService.findPicture(picturePage);
        List<Picture> sydb1 = new ArrayList<Picture>();
        sydb1.add(sydb.get(0));
        List<Picture> sydb2 = new ArrayList<Picture>();
        sydb2.add(sydb.get(1));
        List<Picture> sydb3 = new ArrayList<Picture>();
        sydb3.add(sydb.get(2));
        List<Picture> sydb4 = new ArrayList<Picture>();
        sydb4.add(sydb.get(3));
        List<Picture> sydb5 = new ArrayList<Picture>();
        sydb5.add(sydb.get(4));
        List<Picture> sydb6 = new ArrayList<Picture>();
        sydb6.add(sydb.get(5));
        List<Picture> sydb7 = new ArrayList<Picture>();
        sydb7.add(sydb.get(6));
        List<Picture> sydb8 = new ArrayList<Picture>();
        sydb8.add(sydb.get(7));
        List<Picture> sydb9 = new ArrayList<Picture>();
        sydb9.add(sydb.get(8));
        List<Picture> sydb10 = new ArrayList<Picture>();
        sydb10.add(sydb.get(9));
        List<Picture> sydb11 = new ArrayList<Picture>();
        sydb11.add(sydb.get(10));
        List<Picture> sydb12 = new ArrayList<Picture>();
        sydb12.add(sydb.get(11));
        List<Picture> sydb13 = new ArrayList<Picture>();
        sydb13.add(sydb.get(12));

        model.addAttribute("sydb1", sydb1);
        model.addAttribute("sydb2", sydb2);
        model.addAttribute("sydb3", sydb3);
        model.addAttribute("sydb4", sydb4);
        model.addAttribute("sydb5", sydb5);
        model.addAttribute("sydb6", sydb6);
        model.addAttribute("sydb7", sydb7);
        model.addAttribute("sydb8", sydb8);
        model.addAttribute("sydb9", sydb9);
        model.addAttribute("sydb10", sydb10);
        model.addAttribute("sydb11", sydb11);
        model.addAttribute("sydb12", sydb12);
        model.addAttribute("sydb13", sydb13);
        model.addAttribute("tpzj", tpzj);
        model.addAttribute("sydb", sydb);
        model.addAttribute("wztp", wztp);
        model.addAttribute("xgfy", xgfy);
        model.addAttribute("ygdw", ygdw);
        model.addAttribute("lxfj", lxfj);
        model.addAttribute("jqjj", jqjj);
        model.addAttribute("pictureRotation1", pictureRotation1);
        model.addAttribute("pictureRotation2", pictureRotation2);
        model.addAttribute("pictureRotation3", pictureRotation3);
        model.addAttribute("pictureRotation4", pictureRotation4);
        model.addAttribute("pictureRotation5", pictureRotation5);
        return "main";
    }

    @GetMapping("/category")
    @ApiOperation("跳转分类页面")
    public String SH(Model model, String lb) {
        if (lb.equals("shsh")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("社会生活");
            List<Picture> shsh = pictureService.findPicture(picturePage);
            model.addAttribute("lb", "shsh");
            model.addAttribute("shsh", shsh);
        } else if (lb.equals("cygg")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("创意广告");
            List<Picture> cygg = pictureService.findPicture(picturePage);
            model.addAttribute("cygg", cygg);
            model.addAttribute("lb", "cygg");
        } else if (lb.equals("ktty")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("卡通涂鸦");
            List<Picture> ktty = pictureService.findPicture(picturePage);
            model.addAttribute("ktty", ktty);
            model.addAttribute("lb", "ktty");
        } else if (lb.equals("kxbj")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("酷炫背景");
            List<Picture> kxbj = pictureService.findPicture(picturePage);
            model.addAttribute("kxbj", kxbj);
            model.addAttribute("lb", "kxbj");
        } else if (lb.equals("swbg")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("商业办公");
            List<Picture> swbg = pictureService.findPicture(picturePage);
            model.addAttribute("swbg", swbg);
            model.addAttribute("lb", "swbg");
        } else if (lb.equals("syys")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("摄影艺术");
            List<Picture> syys = pictureService.findPicture(picturePage);
            model.addAttribute("syys", syys);
            model.addAttribute("lb", "syys");
        } else if (lb.equals("ysmx")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("影视明星");
            List<Picture> ysmx = pictureService.findPicture(picturePage);
            model.addAttribute("ysmx", ysmx);
            model.addAttribute("lb", "ysmx");
        } else if (lb.equals("zrfj")) {
            PicturePage picturePage = new PicturePage();
            picturePage.setBigSort("自然风景");
            List<Picture> zrfj = pictureService.findPicture(picturePage);
            model.addAttribute("zrfj", zrfj);
            model.addAttribute("lb", "zrfj");
        }
        return "pour";
    }


    @GetMapping("/search")
    @ApiOperation("搜索分页")
    public String search(PicturePage picturePage1, Model model, HttpSession httpSession, String upDown) {
        if (picturePage1.getName() != null) httpSession.setAttribute("PicturePage", 0);
        //将搜索的内容放到session
        if (picturePage1.getName() != null)
            httpSession.setAttribute("PictureName", picturePage1.getName());

        model.addAttribute("page", pictureService.findPageList((String) httpSession.getAttribute("PictureName")));
        model.addAttribute("max", pictureService.findPageList((String) httpSession.getAttribute("PictureName")).size());

        //获取传来的第几页并存在session中
        int a = picturePage1.getPage();
        if (a != 0) httpSession.setAttribute("PicturePage", a - 1);

        //获取前进或者是后退
        if (upDown != null) {
            if (upDown.equals("up")) {
                httpSession.setAttribute("PicturePage", (Integer) httpSession.getAttribute("PicturePage") + 1);
            }
            if (upDown.equals("down")) {
                httpSession.setAttribute("PicturePage", (Integer) httpSession.getAttribute("PicturePage") - 1);
            }
        }

        model.addAttribute("search", pictureService.findPictureList((String) httpSession.getAttribute("PictureName"), (Integer) httpSession.getAttribute("PicturePage") * 24));
        model.addAttribute("num", (Integer) httpSession.getAttribute("PicturePage") + 1);

        return "bb";
    }

    @GetMapping("/goDetailed")
    @ApiOperation("跳转到详细信息页面")
    public String goDetailed(String name, Model model) {
        PicturePage picturePage = new PicturePage();
        if (name.equals("1")) {
            picturePage.setBigSort("潮流设计");
            model.addAttribute("active", "1");
        } else if (name.equals("2")) {
            picturePage.setBigSort("创意周报");
            model.addAttribute("active", "2");
        } else if (name.equals("3")) {
            picturePage.setBigSort("酷炫灵感");
            model.addAttribute("active", "3");
        } else if (name.equals("4")) {
            picturePage.setBigSort("配色推荐");
            model.addAttribute("active", "4");
        } else if (name.equals("5")) {
            picturePage.setBigSort("四大招式");
            model.addAttribute("active", "5");
        } else if (name.equals("6")) {
            picturePage.setBigSort("自然美景");
            model.addAttribute("active", "6");
        }
        List<Picture> picture = pictureService.findPicture(picturePage);
        model.addAttribute("picture", picture);
        return "font";
    }

    @PostMapping("/feedback")
    @ResponseBody
    @ApiOperation("反馈")
    public String feedback(AccountFeedback accountFeedback) {
        int i = accountFeedbackService.addAccountFeedback(accountFeedback);
        if (i > 0) return "0";
        return "1";
    }

    @GetMapping("/goSixteen")
    @ApiOperation("跳转到那六个页面")
    public String goSixteen(String name, Model model) {
        PicturePage picturePage = new PicturePage();
        if (name.equals("11")) {
            picturePage.setBigSort("创意广告");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "11");
        } else if (name.equals("12")) {
            picturePage.setBigSort("创意广告");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "12");
        } else if (name.equals("21")) {
            picturePage.setBigSort("卡通涂鸦");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "21");
        } else if (name.equals("22")) {
            picturePage.setBigSort("卡通涂鸦");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "22");
        } else if (name.equals("31")) {
            picturePage.setBigSort("酷炫背景");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "31");
        } else if (name.equals("32")) {
            picturePage.setBigSort("酷炫背景");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "32");
        } else if (name.equals("41")) {
            picturePage.setBigSort("商业办公");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "41");
        } else if (name.equals("42")) {
            picturePage.setBigSort("商业办公");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "42");
        } else if (name.equals("51")) {
            picturePage.setBigSort("社会生活");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "51");
        } else if (name.equals("52")) {
            picturePage.setBigSort("社会生活");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "52");
        } else if (name.equals("61")) {
            picturePage.setBigSort("摄影艺术");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "61");
        } else if (name.equals("62")) {
            picturePage.setBigSort("摄影艺术");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "62");
        } else if (name.equals("71")) {
            picturePage.setBigSort("影视明星");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "71");
        } else if (name.equals("72")) {
            picturePage.setBigSort("影视明星");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "72");
        } else if (name.equals("81")) {
            picturePage.setBigSort("自然风景");
            picturePage.setSmallSort("1");
            model.addAttribute("active", "81");
        } else if (name.equals("82")) {
            picturePage.setBigSort("自然风景");
            picturePage.setSmallSort("2");
            model.addAttribute("active", "82");
        }
        List<Picture> picture = pictureService.findPicture(picturePage);
        model.addAttribute("picture", picture);
        return "pour";
    }


    @GetMapping("/goInformationL")
    @ApiOperation("跳转到详细信息")
    public String goInformationL(int id, Model model, HttpSession session) {
        Picture picture = pictureService.findByIdL(id);
        pageViewsService.updatePageView(id);
        model.addAttribute("picture", picture);
        session.setAttribute("pic", picture);
        return "pictureMsg";
    }

    @GetMapping("/collection")
    @ApiOperation("收藏")
    public String Collection(HttpSession session, String name, Model model) {
        String userName = (String) session.getAttribute("userName");
        if (userName != null) {
            Account account = (Account) session.getAttribute("Account");
            AccountCollection accountCollection = new AccountCollection();
            accountCollection.setUserName(account.getUserName());
            accountCollection.setPicturePosition(name);
            accountCollectionService.addAccountCollection(accountCollection);
            accountService.updateAccount(account);
            return "forward:/main/rotation";
        }
        int noLogin = 1;
        model.addAttribute(noLogin);
        return "forward:/account/goLogin";
    }

    @GetMapping("/collectionM")
    @ApiOperation("跳转到详细信息")
    public String CollectionM(HttpSession session, String name, Model model) {
        Account account = (Account) session.getAttribute("Account");
        AccountCollection accountCollection = new AccountCollection();
        accountCollection.setUserName(account.getUserName());
        accountCollection.setPicturePosition(name);
        accountCollectionService.addAccountCollection(accountCollection);
        model.addAttribute("picture", (Picture) session.getAttribute("pic"));
        return "pictureMsg";
    }

    @RequestMapping(value = "/download")
    @ApiOperation("下载")
    public String downloads(HttpSession session, HttpServletResponse response, String name) throws Exception {
        accountDownloadService.addAccountDownload(name, response, (Account) session.getAttribute("Account"));
        return null;
    }

    @RequestMapping(value = "/do")
    @ApiOperation("下载")
    public String download1s(HttpServletResponse response) throws Exception {
        DownloadUtils.download(response, "ygdw%20(1).jpg");
        return null;
    }
}
