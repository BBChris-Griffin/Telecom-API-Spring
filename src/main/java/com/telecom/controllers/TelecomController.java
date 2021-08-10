package com.telecom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.services.TelecomService;

@RestController
public class TelecomController {

	@Autowired
	private TelecomService service;
}
