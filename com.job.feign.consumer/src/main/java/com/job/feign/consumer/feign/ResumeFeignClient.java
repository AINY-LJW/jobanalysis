package com.job.feign.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.comment.util.R;
//@FeignClient(name="commentAnalysis-provider",fallbackFactory = CommentFeignClientFallback.class)
public interface ResumeFeignClient {
//	/**
//	 * 上传简历json
//	 * TODO
//	 * @param 
//	 * @return R
//	 */
//	@PostMapping(value = "resume/upload")
//	public R uploadJson(@RequestBody(required = false) @RequestParam("jsonObj") String jsonObj);
}
