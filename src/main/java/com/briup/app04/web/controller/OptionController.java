package com.briup.app04.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.briup.app04.bean.Option;
import com.briup.app04.service.impl.OptionServiceImpl;
import com.briup.app04.util.MsgResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description="问题选项相关的接口")
@RestController
@RequestMapping("/option")
public class OptionController {
	// 注入ICourseService的实例
	@Autowired
	private OptionServiceImpl optionService;
	
	@ApiOperation(value = "插入多条数据")
	@PostMapping("insertOptions")
	public MsgResponse inserts(@RequestBody List<Option> list) {
		try {	
			optionService.inserts(list);
			return MsgResponse.success("插入成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "插入单条数据")
	@GetMapping("insertOption")
	public MsgResponse insert(Option option) {
		try {
			optionService.insert(option);
			return MsgResponse.success("插入成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "按ID删除数据")
	@GetMapping("deleteOption")
	public MsgResponse delete(long id) {
		try {
			optionService.delete(id);
			return MsgResponse.success("删除成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "查找所有数据")
	@GetMapping("findAllOption")
	public MsgResponse findAll() {
		try {
			List<Option> list = optionService.findAll();
			return MsgResponse.success("查询成功", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "按ID查找数据")
	@GetMapping("findByIdOption")
	public MsgResponse findById(long id) {
		try {
			Option option=optionService.findById(id);
			return MsgResponse.success("查询成功", option);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return MsgResponse.error(e.getMessage());
		}
	}

	@ApiOperation(value = "更新数据")
	@GetMapping("updateOption")
	public MsgResponse update(Option option) {
		try {
			optionService.update(option);
			return MsgResponse.success("更新成功", null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return MsgResponse.error(e.getMessage());
		}
	}
}
