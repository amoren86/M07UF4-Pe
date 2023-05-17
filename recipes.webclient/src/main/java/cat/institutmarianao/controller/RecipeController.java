package cat.institutmarianao.controller;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RecipeController {

	@GetMapping(value = "/")
	public ModelAndView recipes() {
		// TODO Show all recipes (recipes view)
		return null;
	}

	@GetMapping(value = "/recipe_details")
	public ModelAndView recipeDetails(@RequestParam(value = "recipe_id") String recipeId)
			throws ServletException, IOException {

		// TODO Show recipes details (recipe_details view)
		return null;
	}

	@GetMapping(value = "/vote_positive")
	public RedirectView votePositive(@RequestParam(value = "recipe_id") String recipeId,
			@RequestParam(value = "redirect_to") String redirectTo, Model model) {

		// TODO Vote positive

		model.addAttribute("recipe_id", recipeId);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl(redirectTo);
		return redirectView;
	}

	@GetMapping(value = "/vote_negative")
	public RedirectView voteNegative(@RequestParam(value = "recipe_id") String recipeId,
			@RequestParam(value = "redirect_to") String redirectTo, Model model) {

		// TODO Vote negative

		model.addAttribute("recipe_id", recipeId);
		RedirectView redirectView = new RedirectView();
		redirectView.setContextRelative(true);
		redirectView.setUrl(redirectTo);
		return redirectView;
	}
}