package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {
    
    @RequestMapping("/fileDownloadList")
    public String fileDownloadList(Model model){

        File path = new File("C:/springWorkspace/upload");
        String[] fileList = path.list();

        model.addAttribute("fileList", fileList);
        return "upload/fileDownloadListViewForm";
    }

    @RequestMapping("/fileDownload/{file}")
    public void fileDownload(@PathVariable String file, HttpServletResponse response) throws IOException{
        File f = new File("C:/springWorkspace/upload/",file);

        String encodedFileName = new String(file.getBytes("UTF-8"),"ISO-8859-1");
        response.setContentType("application/download");
        response.setContentLength((int)f.length());
        response.setHeader("Content-Disposition", "attatchment;filename=\"" + encodedFileName +"\"");

        FileInputStream fis = new FileInputStream(f);

        OutputStream os = response.getOutputStream();

        FileCopyUtils.copy(fis, os);
    }
}
