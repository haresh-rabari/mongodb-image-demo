package com.images.api.demoforimages.controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class ImageController {

    String fileid="";
    @Autowired
    private GridFsOperations gridFsOperations;

    @GetMapping("/save")
    public String saveImage() throws FileNotFoundException {
        DBObject metaData = new BasicDBObject();
        metaData.put("soh","drh");


        InputStream inputStream=new FileInputStream("C:/Users/admin/Desktop/Ecommerce/images/hero.jpg");
        metaData.put("type","image");

        fileid=gridFsOperations.store(inputStream,"hero.jpg","image/jpg",metaData).toString();

       return "Image Storedd Succesfully" ;

    }


}


