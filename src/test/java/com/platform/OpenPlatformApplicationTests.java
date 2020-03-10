package com.platform;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.platform.bean.Rel;
import com.platform.bean.RespQues;
import com.platform.bean.RespSubject;
import com.platform.bean.Subject;
import com.platform.dao.SubjectDao;
import com.platform.service.QuesService;
import com.platform.service.SubjectService;
import com.platform.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class OpenPlatformApplicationTests {

    @Autowired
    SubjectDao subjectDao;

    @Autowired
    UserService userService;

    @Autowired
    QuesService quesService;

    @Test
    void contextLoads() {
    }

    @Test
    void testMybatis01(){
        System.out.println(subjectDao.findOneSubject().getSubject_name());
    }

    @Test
    void testMybatis02(){
        Subject subject = new Subject();
        //subject.setSubject_id(2);
        subject.setSubject_tag("选修");
        subject.setSubject_name("TEST_SubjectTag02");
        subject.setSubject_path("XXXXX");
        subjectDao.insertSingleSubject(subject);
    }

    @Test
    void testMybatis03(){
        List<RespSubject> subjects = subjectDao.selectAllSubjectByUserName(1);
        subjects.forEach(item->{
            System.out.println(item.getSubject_name());
        });
    }

    @Test
    void testMybatis04(){
        //System.out.println(userService.findSingleUser("Megumi"));
        //System.out.println(userService.findSingleUserByNamePassW("Megumi","123456"));
        userService.addUser("Miziha","123456");
    }
    @Test
    void testDate(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(df.format(new Date()));
    }

    @Test
    void testQues01(){
        System.out.println(quesService.selectAllQuesBySubject(6).get(1));
    }

    @Test
    void testQues02(){
        RespQues ques = new RespQues();
        ques.setSubject_id(6);
        ques.setQues_type("单");
        ques.setQues_desc("以下谁是PG？");
        ques.setAnswer1("宫城良田");
        ques.setAnswer2("流川枫");
        ques.setAnswer3("三井寿");
        ques.setAnswer4("赤木刚宪");

        ques.setTrue_answer("1");
        ques.setCreate_by(0);
        quesService.insertSingleQues(ques);

    }

    @Test
    void testSubject01(){
        subjectDao.selectAllSubject().forEach(item ->{
            System.out.println(item.getSubject_name());
        });
    }

    @Test
    void testRel01(){
        Rel rel = new Rel();
        rel.setUser_id(2);
        rel.setSubject_id(3);
        subjectDao.insertSingleRel(rel);
    }

    @Test
    void testValidSubject() throws JsonProcessingException {
        List<RespSubject> lists = subjectDao.selectAllValidSubjectByUserName("Hinata");
        ObjectMapper om = new ObjectMapper();
        String list = om.writeValueAsString(lists);
        System.out.println(list);
//        Iterator<RespSubject> iterator = lists.iterator();
//        while(iterator.hasNext()){
//            System.out.println("1");
//            RespSubject next = iterator.next();
//            System.out.println(next.getSubject_name());

    }

    @Test
    void testUpdatePoint(){
        userService.UpdateUserPoint(1,"Megumi");
    }
}
