
package com.schoolmonitor.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmonitor.service.DataUploadService;

/**
 * @author PrabhjeetS
 * @version 1.0 Dec 28, 2019
 */
@RestController
@RequestMapping("/schoolmonitor")
public class DataUploadController {
	@Autowired
	DataUploadService dataUploadService;

	@PostMapping("/dataUpload")
	public ResponseEntity<?> dataUpload() {
		return ok(dataUploadService.dataUpload());

	}

}
