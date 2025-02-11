package com.sanjayd.productservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanjayd.productservice.gson.provider.GsonProvider;
import com.sanjayd.productservice.json.model.Response;
import com.sanjayd.productservice.service.ProductService;

@Controller
public class ProductServiceController {

	private static final Logger logger = LoggerFactory.getLogger(ProductServiceController.class);
	
	@Autowired
	private GsonProvider gsonProvider;

	@Autowired
	ProductService productService;

	@CrossOrigin
	@RequestMapping(value = "/getProducts", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String getProducts(@RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			return productService.getProducts();
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/getProductCategories", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String getProductCategories( @RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			return productService.getProductCategories();
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/getBanners", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String getBanners( @RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			return productService.getBanners();
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/getProductSubCategories", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String getProductSubCategories(@RequestBody final String json, @RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			return productService.getProductSubCategories(json);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String addProducts(@RequestBody final String json, @RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			productService.addProducts(json);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/addProductCategory", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String addProductCategory(@RequestBody final String json, @RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			productService.addProductCategory(json);
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	@CrossOrigin
	@RequestMapping(value = "/addProductVersion", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public final String addProductVersion(@RequestBody final String json, @RequestHeader HttpHeaders headers) {
		Response response = new Response();
		try {
			productService.addProductVersion(json);
			response.setStatus("Success");
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setStatus("Error");
			// response.setMessage(e.getMessage());
		}
		return gsonProvider.getGson().toJson(response);
	}

	
	public void setGsonProvider(GsonProvider gsonPro) {
		gsonProvider = gsonPro;
	}

}
