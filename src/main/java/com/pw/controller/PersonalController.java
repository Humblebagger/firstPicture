package com.pw.controller;

import com.pw.pojo.Account;
import com.pw.pojo.AccountCollection;
import com.pw.pojo.AccountDownload;
import com.pw.pojo.Picture;
import com.pw.pojo.utils.PersonUpdate;
import com.pw.service.AccountCollectionService;
import com.pw.service.AccountDownloadService;
import com.pw.service.AccountService;
import com.pw.service.PictureService;
import com.pw.utils.Base64DecodeMultipartFile;
import com.pw.utils.UploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Api(value = "用户接口层次", tags = "个人中心接口")
@Controller
@Slf4j
@RequestMapping(value = "/accountPersonal", produces = "text/html;charset=utf-8")
public class PersonalController {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountDownloadService accountDownloadService;
    @Autowired
    private AccountCollectionService accountCollectionService;

    @PostMapping("/verification")
    @ResponseBody
    @ApiOperation("验证用户名是否已经存在")
    public String verification(String userName) {
        return accountService.verificationName(userName);
    }

    @GetMapping("/goMyCollection")
    @ApiOperation("跳到我的收藏")
    public String goMyCollection(Model model, HttpSession httpSession) {
        Account account = (Account) httpSession.getAttribute("Account");
        List<AccountCollection> accountCollection = accountCollectionService.findAccountCollection(account.getUserName());
        if (accountCollection.size() == 0) model.addAttribute("has", 0);
        model.addAttribute("MyCollection", accountCollection);
        return "personalCollect";
    }

    @GetMapping("/goMyDownload")
    @ApiOperation("跳到我的下载")
    public String goMyDownload(HttpSession session, Model model) {
        Account account = (Account) session.getAttribute("Account");
        List<AccountDownload> accountDownload = accountDownloadService.findAccountDownload(account.getUserName());
        if (accountDownload.size() == 0) model.addAttribute("has", 0);
        model.addAttribute("accountDownload", accountDownload);
        return "personLoad";
    }

    @GetMapping("/goMyUpload")
    @ApiOperation("跳到我的上传")
    public String goMyUpload() {
        return "personalUpload";
    }

    @GetMapping("/goMyCenter")
    @ApiOperation("跳到个人中心")
    public String goMyCenter() {
        return "personCenter";
    }

    @PostMapping("/upload")
    @ApiOperation("上传头像")
    @ResponseBody
    public String fileUpload(String name, HttpSession session) throws IOException {
        MultipartFile file = Base64DecodeMultipartFile.base64Convert(name);
        String PN = file.getOriginalFilename();
        UploadUtils.Upload(file, PN);
        Account account = (Account) session.getAttribute("Account");
        account.setHeadPortrait(PN);
        accountService.updateAccount(account);
        session.setAttribute("Account", accountService.findAccount(account.getId()));
        return PN;
    }

    @PostMapping("/update")
    @ApiOperation("修改信息")
    public String update(PersonUpdate account, HttpSession session) throws IOException {
        Account account1 = (Account) session.getAttribute("Account");
        accountService.updateAccount(account,account1.getId());
        session.setAttribute("Account", accountService.findAccount(account1.getId()));
        return "personCenter";
    }

    @GetMapping("/goPersonalAlter")
    @ApiOperation("跳到修改信息的页面")
    public String goPersonalAlter() {
        return "personalAlter";
    }

    @PostMapping("/uploadBackground")
    @ApiOperation("上传背景图")
    public String uploadBackground(@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws IOException {
        UploadUtils.Upload(file, file.getOriginalFilename());
        Account account = (Account) session.getAttribute("Account");
        account.setId(account.getId());
        account.setBackground(file.getOriginalFilename());
        accountService.updateAccount(account);
        session.setAttribute("Account", accountService.findAccount(account.getId()));
        return "personCenter";
    }

    @PostMapping("/uploadPicture")
    @ApiOperation("上传图片")
    public String uploadPicture(String name, HttpSession session) throws IOException {
        MultipartFile file = Base64DecodeMultipartFile.base64Convert(name);
        String PN = file.getOriginalFilename();
        session.setAttribute("pictureName", PN);
        UploadUtils.Upload(file, PN);
        Account account = (Account) session.getAttribute("Account");
        account.setUploadTimes(account.getUploadTimes() + 1);
        accountService.updateAccount(account);
        session.setAttribute("Account", accountService.findAccount(account.getId()));
        Picture picture = new Picture();
        picture.setName(PN);
        picture.setPosition(PN);
        pictureService.uploadPicture(picture);
        return "personalUpload";
    }

    @GetMapping("/goOut")
    @ApiOperation("退出登录")
    public String goOut(HttpSession session) {
        session.removeAttribute("Account");
        return "forward:/main/rotation";
    }

//    @GetMapping("/goInformationC")
//    @ApiOperation("跳到修稿页面")
//    public String goInformationC(String position, Model model, HttpSession session) {
//        Picture picture = pictureService.findByPosition(position);
//        model.addAttribute("picture", picture);
//        session.setAttribute("pic", picture);
//        return "pictureMsg";
//    }
}
