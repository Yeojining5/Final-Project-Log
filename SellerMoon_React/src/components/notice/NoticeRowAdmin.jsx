import React from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import axios from "axios"
import Swal from 'sweetalert2'

const NoticeRowAdmin = (props) => {

  const { notice } = props; // 구조분해 할당

  let navigate = useNavigate();

  return (
    <>
      <tr id="row" key={notice.NOTCIE_NO}>
        <td>{notice.NOTICE_NO}</td>
        <td>{notice.NOTICE_CATEGORY}</td>
        <td>{notice.NOTICE_TITLE}</td>
        <td>{notice.NOTICE_WRITER}</td>
        <td>{notice.NOTICE_REGDATE}</td>
        <td>{notice.NOTICE_HIT}</td>
        <td>
          <div className="d-flex" style={{margin: "auto"}}>
            <Button onClick={()=>{ navigate('/admin/notice/update/'+notice.NOTICE_NO)}}
                    variant="outline-secondary" id="btn_search" style={{ width:"100px"}}>
              <i className="fa-regular fa-file-lines"></i>
                &nbsp;수정
            </Button>
            {/* ************************[[ 삭제 버튼 클릭 시 해당 Row삭제**************************** */}
            <Button variant="outline-secondary" id="btn_search" style={{ marginLeft: "20px", width:"100px"}}
                    onClick={()=>{
                      Swal.fire({
                        title: '삭제하시겠습니까?',
                        text: "삭제 후에는 되돌릴 수 없습니다.",
                        icon: 'warning',
                        showCancelButton: true,
                        confirmButtonColor: '#3085d6',
                        cancelButtonColor: '#d33',
                        confirmButtonText: '삭제',
                        cancelButtonText: '취소'
                      }).then((result) => {
                        if (result.isConfirmed) { /* ********알림창에서 삭제 클릭 시 axios 실행********** */
                          axios.get(process.env.REACT_APP_SPRING_IP +"notice/noticedelete?notice_no="+notice.NOTICE_NO)
                          .then((response) => {
                            console.log(response);
                            console.log(response.data);
                            window.location.reload();
                            
                            Swal.fire(
                              '삭제되었습니다!',
                              'success'
                            )

                          })
                          .catch((error) => {
                            console.log(error);
                          })
                        }
                      })
            }}> <i className="fa-regular fa-trash-can"></i>
                &nbsp;삭제
            </Button>
            {/* *********************************************************************************** */}
          </div>
        </td>
      </tr>
    </>
  );
};

export default NoticeRowAdmin;