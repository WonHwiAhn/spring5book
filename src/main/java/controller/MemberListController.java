package controller;

import command.ListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.Member;
import service.MemberDao;

import java.util.List;

@Controller
public class MemberListController {
    @Autowired
    private MemberDao memberDao;

    @GetMapping("members")
    public ModelAndView memberList(@ModelAttribute("cmd")ListCommand listCommand) {
        return new ModelAndView("member/memberList");
    }

    @PostMapping("members")
    public String list(@ModelAttribute("cmd")ListCommand listCommand, Model model) {
        if(listCommand.getFrom() != null && listCommand.getTo() != null) {
            List<Member> members = memberDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
            model.addAttribute("members", members);
        }
        return "member/memberList";
    }
}
