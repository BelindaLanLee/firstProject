package jp.co.brightstar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.co.brightstar.model.Pet;
import jp.co.brightstar.model.PetCondition;
import jp.co.brightstar.service.PetService;

@Controller
public class PetController {
	@Autowired
	private PetService service;

	//
	@GetMapping("petloginPage")
	public String petloginPage() {
		return "petloginPage";
	}

	@GetMapping("petInfoList")
	public String petInfoList() {
		return "petInfoList";
	}

	@GetMapping("petInfo")
	public String petInfo() {
		return "petInfo";
	}

	@GetMapping("petReset")
	public ModelAndView petReset(String id) {
		ModelAndView mav = new ModelAndView();
		Pet pet = service.getPetById(id);
		mav.addObject("pet2", pet);
		mav.setViewName("petReset");
		return mav;
	}

	@GetMapping("petSubmit")
	public ModelAndView petSubmit() {
		ModelAndView mav = new ModelAndView();
		List<Pet> pets = service.searchPet();
		//		for (Pet pet : pets) {
		//			System.out.println(pet);
		//		}
		mav.addObject("pets", pets);
		mav.setViewName("petSubmit");
		return mav;
	}

	//	@PostMapping("在什么页面做以下操作，就是什么页面的url网址地址栏的最后一个词，")
	@PostMapping("petloginPage")
	public ModelAndView insertPet(Pet pet) {
		ModelAndView mav = new ModelAndView();

		service.insertPet(pet);
		mav.setViewName("submitPage");//要显示的页面的html文件名
		mav.addObject("pet", pet);//把新增的pet信息追加到上一行显示的页面
		return mav;//页面自动刷新，显示更新后的页面
	}

	@PostMapping("petSubmit")
	public ModelAndView searchPet(PetCondition condition) {
		ModelAndView mav = new ModelAndView();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		mav.addObject("condition", condition);//追加condition信息
		mav.setViewName("petSubmit");//到petSubmit页面
		return mav;//页面自动刷新，显示更新后的页面
	}

	@PostMapping("petReset")
	public ModelAndView petReset(Pet pet) {
		ModelAndView mav = new ModelAndView();
		service.petReset(pet);
		//		mav.setViewName("petReset");
		mav.addObject("pet2", pet);
		mav.setViewName("petReset");
		return mav;

	}

	@PostMapping("deletePet")
	@ResponseBody
	public String delete(String id, String name) {
		//service.deletePet(id);
		System.out.println(id + name);
		return "ペット「" + name + "」を削除に成功しました！";
	}

}
