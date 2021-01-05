package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
@RequestMapping(value="/",method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv) {
mv.addObject("name","名前がここに入ります");
mv.addObject("age","年齢がここに入ります");
mv.addObject("height","身長がここに入ります");
mv.setViewName("index");
return mv;
}
@RequestMapping(value="/", method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv,@RequestParam("nameVal")String
		name,
		@RequestParam("ageVal")String age,@RequestParam("heightVal")String height) {
	mv.addObject("name", name);
	mv.addObject("age", age);
	mv.addObject("height", height);
	mv.setViewName("index");
	return mv;	
}
@RequestMapping("/{name}")
public ModelAndView index(@PathVariable String name, ModelAndView mv){
	mv.addObject("name", name);
	mv.setViewName("index");
	return mv;
}
@RequestMapping("/{num}")
public ModelAndView index(@PathVariable int num, ModelAndView mv){
	String line="";
	for(int i=0; i<num; i++) line+="あ";
	mv.addObject("name", line);
	mv.setViewName("index");
	return mv;
}
@RequestMapping(value = "/day20" ,method = RequestMethod.GET)
public ModelAndView dayGet(ModelAndView mv) {
	mv.addObject("factorial" ,"階乗の計算をします");
	mv.setViewName("day20");
	return mv;
}
@RequestMapping(value = "/day20" ,method = RequestMethod.POST)
	public ModelAndView dayPost(ModelAndView mv,@RequestParam("factorialVal")int factorial) {
	int total = 0;
	for(int i  = 0;i <= factorial;i++) {
		total = total+i;
	}
	System.out.println(total);
	mv.addObject("factorial",factorial+ "の階乗は" + total + "です！");
	mv.setViewName("day20");
	return mv;
}
@RequestMapping(value="/day21", method=RequestMethod.GET)
public ModelAndView day21Get(ModelAndView mv) {
	mv.addObject("suzuki",65);
	mv.setViewName("day21");
	return mv;
}
@RequestMapping(value="/day21", method=RequestMethod.POST)
public ModelAndView day21POST(ModelAndView mv) {
	mv.addObject("suzuki","off");
	mv.setViewName("day21");
	return mv;
}
@RequestMapping("/day22/{number}")
public ModelAndView day22(@PathVariable int number, ModelAndView mv) {
	if(number % 2 == 0||number % 3 == 0) {
		mv.addObject("number",number+"は素数ではありません");
	}else if(number % 2 != 0||number % 3 != 0) {
		mv.addObject("number",number+"は素数です");
	}
//	mv.addObject("number",number);
	mv.setViewName("day22");
	return mv;
}
@RequestMapping(value="/day22",method=RequestMethod.GET)
public ModelAndView day22(ModelAndView mv) {
mv.addObject("number","計算します");
mv.setViewName("day22");
return mv;
}
}



