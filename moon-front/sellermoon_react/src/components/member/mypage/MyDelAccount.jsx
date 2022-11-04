import React from "react";
import { useState } from "react";
import { Button } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import { delMember } from "../../../service/dbLogic";

const MyDelAccount = ({ no }) => {
  let navigate = useNavigate();
  const [isCheck, setIsCheck] = useState(false);
  const isChecked = (e) => {
    if (e.target.checked) {
      setIsCheck(true);
      console.log("setIsCheck =====> ", isCheck);
    } else {
      console.log("setIsCheck =====> ", isCheck);
    }
  };
  const delMem = () => {
    if (isCheck === true) {
      delMember({ member_no: no }).then((res) => {
        console.log(res.data);
        if (res.data === 1) {
          alert("탈퇴되었습니다.");
          sessionStorage.clear();
          navigate("/");
          window.location.reload();
        } else {
          alert("오류가 있습니다");
        }
      });
    } else {
      alert("동의해주세요");
    }
  };
  return (
    <>
      <h1>탈퇴하기</h1>
      이용약관 블라블라 적립금 다 없어짐 ㄱㅊ?
      <br />
      <div className="form-check">
        <input
          className="form-check-input"
          type="checkbox"
          value={isCheck}
          onChange={isChecked}
          id="flexCheckDefault"
        />
        <label className="form-check-label">동의합니다</label>
      </div>
      <Button onClick={delMem}>탈퇴</Button>
    </>
  );
};

export default MyDelAccount;
