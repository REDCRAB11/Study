package com.kh.spring17.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring17.entity.ProductDto;
import com.kh.spring17.repository.ProductDao;
import com.kh.spring17.vo.ProductSearchVO;

@Controller
public class TestController {

		@Autowired
		private ProductDao productDao;
		
		@RequestMapping("/")
		public String home(@ModelAttribute ProductSearchVO vo, Model model) {
			List<ProductDto> list = productDao.complexSearch(vo);
			model.addAttribute("list", list);
			return"list";
		}
}
