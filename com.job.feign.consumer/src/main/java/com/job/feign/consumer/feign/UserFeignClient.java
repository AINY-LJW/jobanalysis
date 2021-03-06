package com.job.feign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.comment.common.domain.User;
import com.comment.util.EasyUIDataGridResult;
import com.comment.util.R;

/**
 * 
 * 简述部分: * Feign接口，并增加 @FeignClient(name="service-user") 注解用以适应Eureka和Ribbon，
 * 里面的方法是和服务端提供的接口对应的
 *
 * @author WK
 * @version 2020年1月23日
 */
//注解里面写你在  Eureka注册的提供服务者的名字
//增加 fallbackFactory配置   Hystrix容错处理
//@Component
@FeignClient(name="commentAnalysis-provider",fallbackFactory = CommentFeignClientFallback.class)
public interface UserFeignClient {
	/**=====================================以下公司信誉档案==========================================*/
	
	/**
	 * 返回json数据做词云图
	 * 
	 * @return String
	 */
	@GetMapping("/companyCredit/getTextCloudJson")
	public String getTextCloudJsonForIndustry();
	
	@PostMapping("companyCredit/changeCompanyCrediState")
	public R changeCompanyCrediState(@RequestBody @RequestParam("id") int id,
			@RequestParam("state") boolean state) ;
	
	@PostMapping("companyCredit/getOwnCompanyCredit")
	public EasyUIDataGridResult getOwnCompanyCredit(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord,@RequestParam("companyId") int companyId);
	
	@PostMapping("companyCredit/getAllCompanyCredit")
	public EasyUIDataGridResult getAllCompanyCredit(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord,@RequestParam("uid")Integer uid) ;
	
	@PostMapping("companyCredit/like")
	public EasyUIDataGridResult getResumeLike(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord,@RequestParam("uid") Integer uid) ;
	/**=====================================以下简历==========================================*/
	
	/**
	 * 更改个人经历公开状态
	 * TODO
	 * @param 
	 * @return R
	 */
	@PostMapping("resume/changeState")
	public R changeResumeState(@RequestBody @RequestParam("id") String id,
			@RequestParam("index") int index);
	
	/**
	 * 上传简历json
	 * TODO
	 * @param 
	 * @return R
	 */
	@PostMapping(value = "resume/upload")
	public R uploadJson(@RequestBody(required = false) @RequestParam("jsonObj") String jsonObj);
	
	/**
	 * 根据关键词查找评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("resume/getResumeByKeywords")
	//
	EasyUIDataGridResult getResumeByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord, @RequestParam("identity") String identity);
	/**=====================================以下为评论分析  可以不看==========================================*/
	/*
	 * @GetMapping("/user/getName") public String getUser();
	 */
	/**
	 * 获取评论统计json数据
	 * 
	 * @return String
	 */
	@GetMapping("/user/getStatistics")
	String getCommentStatistics() ;
	/**
	 * 获取评论列表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getCommentList")
	public EasyUIDataGridResult getCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 上传json 保存评论数据
	 * 
	 * @param jsonObj
	 * @return String
	 */
	@PostMapping(value = "/user/saveJson")
	public String getUserById4(@RequestBody @RequestParam("jsonObj") String jsonObj);

	/**
	 * 获取积极评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getPositiveCommentList")
	public EasyUIDataGridResult getPositiveCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取负面评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getNegativeCommentList")
	public EasyUIDataGridResult getNegativeCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取中性评论
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getMiddleCommentList")
	public EasyUIDataGridResult getMiddleCommentList(@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize);

	/**
	 * 获取产品平均分
	 * 
	 * @param asin
	 * @return String
	 */
	@PostMapping("/user/getAverage")
	public String getAverageAsin(@RequestBody @RequestParam("asin") String asin);

	/**
	 * 关键词查找
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param asin
	 * @param reviewerName
	 * @param keyWord
	 * @return EasyUIDataGridResult
	 */
	@PostMapping("/user/getCommentsByKeywords")
	public EasyUIDataGridResult getCommentsByKeywords(@RequestBody @RequestParam("page") int pageNum,
			@RequestParam("rows") int pageSize, @RequestParam(value = "asin", required = false) String asin,
			@RequestParam(value = "reviewerName", required = false) String reviewerName,
			@RequestParam(value = "keyWord", required = false) String keyWord);

	/**
	 * 验证登陆
	 * 
	 * @param name
	 * @param pwd
	 * @return User
	 */
	@PostMapping(value = "/user/loginForm")
	public User ifUserExist(@RequestBody @RequestParam("form-username") String name,
			@RequestParam("form-password") String pwd,@RequestParam("form-identity") String identity);

	/**
	 * 返回json数据做词云图
	 * 
	 * @return String
	 */
	@GetMapping("/user/getTextCloudJson")
	public String getTextCloudJson();
}
