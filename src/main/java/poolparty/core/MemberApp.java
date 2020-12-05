package poolparty.core;

import poolparty.core.member.Grade;
import poolparty.core.member.Member;
import poolparty.core.member.MemberService;
import poolparty.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(); 
        Member member = new Member(1L, "caitlyn", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
