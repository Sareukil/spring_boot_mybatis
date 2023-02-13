package com.spring_boot_mybatis.project.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping("/fileUploadForm")
    public String fileUploadForm(){
        return "upload/fileUploadForm";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("uploadFile")MultipartFile file,
                                Model model) throws IOException{
        String uploadPath = "C:/springWorkspace/upload/";

        String originalFileName = file.getOriginalFilename();

        UUID uuid = UUID.randomUUID();
        String savedFileName = uuid.toString() + "_" + originalFileName;

        File sendFile = new File(uploadPath + savedFileName);

        file.transferTo(sendFile);
        model.addAttribute("originalFileName",originalFileName);
        return "upload/fileUploadResultView";
    }

    @RequestMapping("/fileUploadMultiple")
    public String fileUploadMultiple(@RequestParam("uploadFileMulti") ArrayList<MultipartFile> files,
                                        Model model) throws IOException{
        String uploadPath = "C:/springWorkspace/upload/";

        ArrayList<String> originalFileNameList = new ArrayList<>();

        for(MultipartFile file : files){

            String originalFileName = file.getOriginalFilename();

            originalFileNameList.add(originalFileName);

            UUID uuid = UUID.randomUUID();
            String savedFileName = uuid.toString() + "_" + originalFileName;
    
            File sendFile = new File(uploadPath + savedFileName);
    
            file.transferTo(sendFile);

        }
        model.addAttribute("originalFileNameList",originalFileNameList);
        return "upload/fileUploadMultipleResultView";

    }

    @RequestMapping("/fileOriginalFileNameUpload")
    public String fileOriginalFileNameUpload(@RequestParam("uploadOriginalFile")MultipartFile file,
                                Model model) throws IOException{
        String uploadPath = "C:/springWorkspace/upload/";

        String originalFileName = file.getOriginalFilename();

        File sendFile = new File(uploadPath + originalFileName);

        file.transferTo(sendFile);
        
        model.addAttribute("originalFileName",originalFileName);
        return "upload/fileUploadResultView";
    }

    @RequestMapping("/imageFileUploadForm")
    public String imageFileUpload(){
        return "upload/imageFileUploadForm";
    }
    @RequestMapping("/audioFileUploadForm")
    public String audioFileUploadForm(){
        return "upload/audioFileUpload";
    }
    @RequestMapping("/recordFileUploadForm")
    public String recordFileUploadForm(){
        return "upload/recordFileUpload";
    }
    @ResponseBody
    @RequestMapping("/allFileUpload")
    public String allFileUpload(@RequestParam("uploadFile") MultipartFile file) throws IOException{

        String uploadPath = "C:/springWorkspace/upload/";

        String originalFileName = file.getOriginalFilename();

        File sendFile = new File(uploadPath + originalFileName);

        file.transferTo(sendFile);
        
        String result = "success";
        return result;
    }

    

    
}
