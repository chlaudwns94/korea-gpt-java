package com.korit.springboot_study.controller;

import com.korit.springboot_study.dto.request.study.ReqStudentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@Api(tags = "REST API 수업")
public class FirstRestController {

    @GetMapping("/api/hello")
    public Map<String, Object> hello(HttpServletRequest request) {
        String age = request.getParameter("age");
        String address = request.getParameter("address");

        System.out.println(age);
        System.out.println(address);

        return Map.of("name", "ㅇㅇㅇ");
    }
    @GetMapping("/api/hello2")
    public Map<String, Object> hello2(
            @RequestParam int age,
            @RequestParam String address) {

        System.out.println(age);
        System.out.println(address);

        return Map.of("name", "ㅇㅇㅇ");
    }

    // /api/student/1
    @ApiOperation(value = " 학생 조회(일반 for 선형탐색)", notes = "일반 for문을 사용하여 선형 탐색학습")
    @GetMapping("/api/student")
    public Map<String, Object> getStudent(
            @ApiParam(value = "조회할 학생 인덱스", required = true)
            @RequestParam int studentId
    ) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 11, "name", "OOO", "age", 26));
        students.add(Map.of("id", 22, "name", "OOO", "age", 32));
        students.add(Map.of("id", 33, "name", "OOO", "age", 28));
        students.add(Map.of("id", 44, "name", "OOO", "age", 25));

        int foundIndex = -1;

        for (int i = 0; i < students.size(); i++) {
            if ((Integer) students.get(i).get("id") == studentId) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex == -1) {
            return Map.of("error", "찾지 못했습니다.");
        }

        return students.get(foundIndex);
    }

    @ApiOperation(value = "학생 검색", notes = "향상된 for문을 사용하여 선형 탐색학습")
    @GetMapping("/api/student2")
    public Map<String, Object> getStudent2(
            @ApiParam(value = "조회할 학생 id", required = true)
            @RequestParam int studentId) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 11, "name", "OOO", "age", 26));
        students.add(Map.of("id", 22, "name", "OOO", "age", 32));
        students.add(Map.of("id", 33, "name", "OOO", "age", 28));
        students.add(Map.of("id", 44, "name", "OOO", "age", 25));

        Map<String, Object> foundStudent = null;

        for (Map<String, Object> student : students) {
            if ((Integer) student.get("id") == studentId) {
                foundStudent = student;
                break;
            }
        }
        if (foundStudent == null) {
            return Map.of("error", "찾지 못했음");
        }
        return foundStudent;
    }
    @ApiOperation(value = "학생 조회하기", notes = "stream을 사용하여 선형 탐색 합습")
    @GetMapping("/api/student3")
    public Map<String, Object> getStudent3(
            @ApiParam(value = "id롤 학생 검색", required = false)
            @RequestParam(required = false) int studentId) {
        List<Map<String, Object>> students = new ArrayList<>();
        students.add(Map.of("id", 11, "name", "OOO", "age", 26));
        students.add(Map.of("id", 22, "name", "OOO", "age", 32));
        students.add(Map.of("id", 33, "name", "OOO", "age", 28));
        students.add(Map.of("id", 44, "name", "OOO", "age", 25));

        Map<String, Object> responseData = students.stream()
                .filter(student -> (Integer) student.get("id") == studentId)
                .findFirst()
                .orElse(Map.of("error", "찾지못했음"));

        return responseData;
    }

    @GetMapping("/api/student4/{studentId}")
    public Map<String, Object> getStudent4(
            @ApiParam(value = "학생 ID", required = true)
            @PathVariable int studentId,
            ReqStudentDto reqStudentDto
            ) {
        return Map.of("id", studentId, "name", reqStudentDto.getName(), "age", reqStudentDto.getAge());
    }
}
