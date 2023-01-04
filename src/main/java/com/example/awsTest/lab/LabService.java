package com.example.awsTest.lab;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@Service
@Transactional
@Slf4j
public class LabService {
    public void getExcelDownLoad(HttpServletResponse response) {

        try {

            log.info("getExcelDownLoad");

            Workbook workbook = new XSSFWorkbook();//XSSFWorkbook : MS Excel 2007 이상 버전부터 지원 (.xlsx 파일)

            Sheet sheet = workbook.createSheet("엑셀_다운로드_테스트");//엑셀 시트 생성

            CellStyle style = workbook.createCellStyle();//엑셀에 데이터 포맷 지정
//            style.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

//
            style.setAlignment(HorizontalAlignment.CENTER);//정렬
            style.setVerticalAlignment(VerticalAlignment.TOP);

            //파일명
            final String fileName = "엑셀_다운로드_테스트";

            //헤더
            final String[] header = {"ID", "NAME", "PHONE_NUMBER"};
            Row row = sheet.createRow(0);
            for (int i = 0; i < header.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(header[i]);
            }

            UserInfo userInfo1 = new UserInfo();
            userInfo1.setSeq(1);
            userInfo1.setName("cookie");
            userInfo1.setPhoneNumber("010-1111-1111");

            UserInfo userInfo2 = new UserInfo();
            userInfo2.setSeq(2);
            userInfo2.setName("sickBBang");
            userInfo2.setPhoneNumber("010-2222-2222");

            UserInfo userInfo3 = new UserInfo();
            userInfo3.setSeq(3);
            userInfo3.setName("workingAnt");
            userInfo3.setPhoneNumber("010-3333-3333");

            List<UserInfo> userInfoList = new ArrayList<>();
            userInfoList.add(userInfo1);
            userInfoList.add(userInfo2);
            userInfoList.add(userInfo3);


            //바디
            for (int i = 0; i < userInfoList.size(); i++) {
                row = sheet.createRow(i + 1);  //헤더 이후로 데이터가 출력되어야하니 +1

                UserInfo user = userInfoList.get(i);

                Cell cell = null;
                cell = row.createCell(0);
                cell.setCellValue(user.getSeq());

                cell = row.createCell(1);
                cell.setCellValue(user.getName());

                cell = row.createCell(2);
                cell.setCellValue(user.getPhoneNumber());

//            cell = row.createCell(4);
//            cell.setCellStyle(numberCellStyle);      //숫자포맷 적용
//            cell.setCellValue(userPoint.getPaySum());
            }

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8")+".xlsx");
            //파일명은 URLEncoder로 감싸주는게 좋다!

            workbook.write(response.getOutputStream());
            workbook.close();

            response.getOutputStream().close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
