package kh.sellermoon.member.vo;

import lombok.Data;

@Data
public class SubsVO {
	
	private int    sub_no            = 0;
	private String sub_start         = "";
	private String sub_end           = "";
	private int    sub_period        = 0;
	private int    md_no             = 0;
	private int    member_no         = 0;
	private String md_name 			 = "";
	private String md_content 		 = "";
	private int md_price 			 = 0;
	private int st_amount 			 = 0;
	private String member_name 		 = "";
	private String member_address 	 = "";
	private String member_address_detail = "";
	

}

