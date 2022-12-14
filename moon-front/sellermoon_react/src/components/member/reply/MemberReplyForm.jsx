import React from 'react';
import { Button, Form } from 'react-bootstrap';
import { useNavigate, useParams } from 'react-router-dom';

/*
  <<<<< 회원 댓글 작성 폼 >>>>>
    - 추가할 것 : 댓글 사진 기능(cloudinary)
*/
const MemberReplyForm = (props) => {
  console.log("memberReplyForm 호출 성공");

  // 현재 글 번호 
  const { board_no } = useParams();
  console.log("현재 글 번호 : " +  board_no); // 이현 회원번호랑 댓글내용 작성하는 부분 어디야?
  
  const navigate = useNavigate();

  // [C] 댓글 전송 버튼 ----------------------------------------
  const replySubmitBtn = (event) => {
    if(window.confirm("댓글을 등록하시겠습니까?")) {
      // 폼 전송이 일어나는 곳
      document.querySelector("#f_reply").action = "http://localhost:9005/member/board/replyInsert";
      document.querySelector("#f_reply").submit();
      // 페이지 새로고침
    } else {
      event.preventDefault();
       // 토스트로 변경
      alert("등록이 취소되었습니다.");
    }
  }

  // ******************** RENDER ********************
  return (
    <>
      <div className='container'>

        <hr />

        <Form id="f_reply" method="get">

          <input type="hidden" name="board_no" id="board_no" value={ board_no } />

          <Form.Group className="mb-3" controlId="formBawsicReply_content">
            <Form.Control
              type="text" 
              name="reply_content" 
              placeholder="내용을 입력해주세요."
            />
          </Form.Group>


          {/* 회원번호는 임시.. 로그인-세션과 결합 후 지울 것.. */} 
          <Form.Group className="mb-3" controlId="formBasicMember_no">
            <Form.Label>회원번호</Form.Label>
            <Form.Control 
              type="text" 
              name="member_no" 
              placeholder="회원번호를 입력해주세요." 
            />
          </Form.Group>

        </Form>

        <Button variant="primary" onClick={replySubmitBtn}>
          등록
        </Button>

      </div>
    </>
  );
}

export default MemberReplyForm;