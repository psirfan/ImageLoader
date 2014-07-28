package com.iloader.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.iloader.bo.CopyToD;


@Controller
public class FileUploadController {
	
	 @Autowired
	 CopyToD copyToD;
	 
    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {        	
        	
        	copyToD.copyImage(file);
           return "You successfully uploaded " + file.getOriginalFilename() + " into " + file.getOriginalFilename() + "-uploaded !";
           
        } else {
            return "You failed to upload " +file.getOriginalFilename() + " because the file was empty.";
        }
    }

}