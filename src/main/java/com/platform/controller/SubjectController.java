package com.platform.controller;

import com.platform.bean.*;

import com.platform.service.SubjectService;
import com.platform.service.UserService;
import com.platform.utils.ChangeObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@RestController
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    @ResponseBody
    public String uploadSingleFile(@RequestParam("PathParam") String PathParam) {
        return PathParam;
    }

    @RequestMapping(value = "/uploadSingleFile", method = {RequestMethod.POST})
    public String uploadSingleFile(@RequestParam("Upload") MultipartFile Upload) {

        System.out.println("receive request");
        String Path = null;

        try {
            File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(rootPath.getAbsolutePath(),"upload/");
            if (!upload.exists()){
               boolean result =  upload.mkdirs();
            }
            Path = upload.getPath()+"/" + Upload.getOriginalFilename();
            byte[] bytes = Upload.getBytes();
            Path path = Paths.get(Path);
            Files.write(path, bytes);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Path;
        }
        return Path;
    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Resource> download(@RequestParam("PathParam") String PathParam) throws IOException {
        System.out.println("getReq");
        File file2Upload = new File(PathParam);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file2Upload));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file2Upload.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

    @RequestMapping(value = "/getUserAllSubject", method = RequestMethod.POST)
    @ResponseBody
    public List<RespSubject> getUserAllSubject(@RequestParam("userId") int userId) {
        return subjectService.selectAllSubjectByUserName(userId);
    }

    @RequestMapping(value = "/addSubject", method = RequestMethod.POST)
    @ResponseBody
    public RespMsg addSubject(@RequestBody ReqSubject req) throws ParseException {
        RespMsg respMsg = new RespMsg();
        System.out.println(req.toString());
        try {
            Subject subject = ChangeObject.getSubjectByReq(req, req.getCreator());
            System.out.println(subject.toString());
            subjectService.insertSingleSubject(subject);
        } catch (Exception e) {
            respMsg.setCode("failure");
            respMsg.setMessage(e.getMessage());
            respMsg.setStatus(-100);
            return respMsg;
        }
        respMsg.setCode("success");
        respMsg.setMessage("新增课程成功");
        respMsg.setStatus(200);
        return respMsg;
    }

    @RequestMapping(value = "/getAllSubject", method = RequestMethod.GET)
    @ResponseBody
    public List<RespSubject> getAllSubject() {
        return subjectService.selectAllSubject();
    }

    @RequestMapping(value = "/addSubjectUserRel", method = RequestMethod.GET)
    @ResponseBody
    public RespMsg addSubjectUserRel(@RequestParam("userId") int userId, @RequestParam("subjectId") int subjectId) {
        RespMsg respMsg = new RespMsg();
        Rel rel = new Rel();
        rel.setSubject_id(subjectId);
        rel.setUser_id(userId);
        AtomicBoolean isExiting = new AtomicBoolean(false);
        List<Rel> relList = subjectService.getUserSubjectRelByUserId(userId);
        relList.forEach((item) -> {
            if (item.getSubject_id() == subjectId && item.getUser_id() == userId) {
                isExiting.set(true);
            }
        });
        if (isExiting.get()) {
            respMsg.setCode("failure");
            respMsg.setMessage("已经订阅,无法重复订阅");
            respMsg.setStatus(-100);
            return respMsg;
        }
        try {
            subjectService.insertSingleRel(rel);
        } catch (Exception e) {
            respMsg.setCode("failure");
            respMsg.setMessage(e.getMessage());
            respMsg.setStatus(-100);
            return respMsg;
        }
        respMsg.setCode("success");
        respMsg.setMessage("订阅成功");
        respMsg.setStatus(200);
        return respMsg;
    }

    @RequestMapping(value = "/getAllSubjectByCreator", method = RequestMethod.GET)
    @ResponseBody
    public List<SubjectCreatorRes> getAllSubjectByCreator(@RequestParam("userId") int userId) {
        List<SubjectCreatorRes> result = subjectService.selectAllSubjectByCreator(userId);
        return result;
    }

    @RequestMapping(value = "/deleteUserSubjectRelation", method = RequestMethod.GET)
    @ResponseBody
    public RespMsg deleteUserSubjectRelation(@RequestParam("userId") int userId, @RequestParam("subjectId") int subjectId) {
        RespMsg respMsg = new RespMsg();
        try {
            subjectService.deleteUserSubjectRelation(userId, subjectId);
        } catch (Exception e) {
            respMsg.setCode("failure");
            respMsg.setMessage(e.getMessage());
            respMsg.setStatus(-100);
            return respMsg;
        }
        respMsg.setCode("success");
        respMsg.setMessage("订阅成功");
        respMsg.setStatus(200);
        return respMsg;
    }

    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    @ResponseBody
    public RespMsg insertComment(@RequestBody CommentRequestModel request){
        RespMsg respMsg = new RespMsg();
        Date currentDate = new Date();
        try {
            subjectService.insertComment(request.getUserId(),request.getSubjectId(),request.getComment(),currentDate);
        }catch (Exception e){
            e.printStackTrace();
            respMsg.setCode("failure");
            respMsg.setMessage("添加评论失败");
            respMsg.setStatus(-100);
            return respMsg;
        }
        respMsg.setCode("success");
        respMsg.setMessage("添加评论成功");
        respMsg.setStatus(200);
        return respMsg;
    }

    @RequestMapping(value = "/getSubjectCommentBySubjectId",method = RequestMethod.GET)
    @ResponseBody
    public List<CommentViewModel> getSubjectCommentBySubjectId(@RequestParam int subjectId){
        return subjectService.getCommentBySubjectId(subjectId);
    }

    @RequestMapping(value = "/downloadOffLine", method = RequestMethod.GET)
    public void downLoad(@RequestParam("PathParam") String filePath, HttpServletResponse response) throws Exception {
        File f = new File(filePath);
        if (!f.exists()) {
            response.sendError(404, "File not found!");
            return;
        }
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
        byte[] buf = new byte[1024];
        int len = 0;

        response.reset(); // 非常重要
        // 纯下载方式
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + f.getName());

        OutputStream out = response.getOutputStream();
        while ((len = br.read(buf)) > 0)
            out.write(buf, 0, len);
        br.close();
        out.close();
    }

    @RequestMapping(value = "getAllValidSubject",method = RequestMethod.GET)
    public List<RespSubject> getAllValidSubject(@RequestParam("stuName") String stuName){
        return subjectService.selectAllValidSubjectByUserName(stuName);
    }

}
