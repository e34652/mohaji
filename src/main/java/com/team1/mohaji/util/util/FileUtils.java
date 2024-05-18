package com.team1.mohaji.util.util;

import com.team1.mohaji.dto.AttachedDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FileUtils {

	public List<AttachedDto> parseFileInfo(int postId, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)){
			return null;
		}

		List<AttachedDto> fileList = new ArrayList<>();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
//    	String path = "images/"+current.format(format);
		String path = "./src/main/resources/static/file/"+current.format(format);
		File file = new File(path);
		if(file.exists() == false){
			file.mkdirs();
		}

		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

		String newFileName, originalFileExtension, contentType;

		while(iterator.hasNext()){
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
			for (MultipartFile multipartFile : list){
				if(multipartFile.isEmpty() == false){
					contentType = multipartFile.getContentType();
					if(ObjectUtils.isEmpty(contentType)){
						break;
					}
					else{
						if(contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						}
						else if(contentType.contains("image/png")) {
							originalFileExtension = ".png";
						}
						else if(contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						}
						else{
							break;
						}
					}

					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
					AttachedDto boardFile = new AttachedDto();
					boardFile.setPostId(postId);
					boardFile.setAttachedSize(multipartFile.getSize());
					boardFile.setOriginalName(multipartFile.getOriginalFilename());
//					boardFile.setStoredFilePath(path + "/" + newFileName);
					boardFile.setStoragePath("/file/"+ current.format(format) +"/"+ newFileName);
					fileList.add(boardFile);

					file = new File(path + "/" + newFileName);
					multipartFile.transferTo(file);
				}
			}
		}
		return fileList;
	}
}
