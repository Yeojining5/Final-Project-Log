import React, { useState } from "react";
import { Modal } from "react-bootstrap";
import { reviewDelete } from "../../../service/dbLogic";
import { PLUSBTN, STARSPAN } from "../../../styles/ReviewStyle";
import MemberReviewM from "../product_review/MemberReviewM";

const MyReviewRow = ({ review, no }) => {
  const [limit, setLimit] = useState(30); // 더보기 버튼 글자수 제한
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const toggleEllipsis = (str, limit) => {
    return {
      string: str.slice(0, limit),
      isShowMore: str.length > limit,
    };
  };
  const onClickMore = (str) => () => {
    setLimit(str.length);
  };
  // 삭제 버튼
  const delReview = () => {
    console.log(review.MD_REVIEW_NO);
    reviewDelete({ md_review_no: review.MD_REVIEW_NO }).then((res) => {
      console.log(res.data);
      if (res.data === 1) {
        alert("삭제되었습니다!");
        window.location.reload();
      }
    });
  };
  return (
    <>
      <br />
      상품명: {review.MD_NAME}
      <div>
        별점 :
        {review.MD_STAR === 1 ? (
          <STARSPAN>★</STARSPAN>
        ) : review.MD_STAR === 2 ? (
          <STARSPAN>★★</STARSPAN>
        ) : review.MD_STAR === 3 ? (
          <STARSPAN>★★★</STARSPAN>
        ) : review.MD_STAR === 4 ? (
          <STARSPAN>★★★★</STARSPAN>
        ) : (
          <STARSPAN>★★★★★</STARSPAN>
        )}
      </div>
      내용 : {toggleEllipsis(review.MD_REVIEW_CONTENT, limit).string}
      {toggleEllipsis(review.MD_REVIEW_CONTENT, limit).isShowMore && (
        <PLUSBTN onClick={onClickMore(review.MD_REVIEW_CONTENT)}>
          ...더보기
        </PLUSBTN>
      )}
      <div>작성일 : {review.MD_REVIEW_WRITTEN_DATE}</div>
      <div> 좋아요 : {review.MD_REVIEW_LIKE}</div>
      {no == review.MEMBER_NO ? (
        <button onClick={delReview}>삭제</button>
      ) : null}
      &nbsp;
      {no == review.MEMBER_NO ? (
        <button onClick={handleShow}>수정</button>
      ) : null}
      <br />
      <Modal show={show} onHide={handleClose}>
        <MemberReviewM review={review} no={no} />
      </Modal>
    </>
  );
};

export default MyReviewRow;
