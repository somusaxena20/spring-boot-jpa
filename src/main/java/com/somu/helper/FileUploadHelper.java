package com.somu.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    private final String UPLOAD_DIR = "src/main/resources/static/file_upload";

    public boolean uploadFile(MultipartFile f)
    {
        boolean flag = false;

        try {

//            1st Way

//            InputStream is = f.getInputStream();
//            byte []b = new byte[is.available()];
//
//            is.read(b);
//
//            FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+"/"+f.getOriginalFilename());
//
//            fos.write(b);
//
//            fos.flush();
//            fos.close();

//            2nd Way

            Files.copy(f.getInputStream(), Paths.get(UPLOAD_DIR+ File.separator+f.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);

            flag = true;

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return flag;
    }
}
