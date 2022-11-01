import React from 'react';
import { Col, Form, Row, Button, Modal, Container } from 'react-bootstrap';
import { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { BROWN_BTN } from '../../../styles/NoticeStyle';
import Pagination from './../../member/Common/Pagination';
import PointRowAdmin from './PointRowAdmin';
import { pointlist } from './../../../service/dbLogic';
import axios from "axios"


const PointAdmin = () => {

  let navigate = useNavigate();

  const [pointList, setPointList] = useState([])

  /**************** 페이지네이션 선언 ********************/
  const [limit, setLimit] = useState(10);
  const [page, setPage] = useState(1);
  const offset = (page - 1) * limit;
  /* ************************************************** */

  /* noticelist 데이터 가져오기 */
  useEffect(() => {
    const oracleDB = async () => {
        //const result = await jsonDeptList({ DEPTNO: 30 }) -> 스프링콘솔에 com.example.demo.dao.DeptDao  : pMap : {DEPTNO=30}
        const result = await pointlist() // pMap : {}
        //console.log(result)
        console.log(result.data)
        setPointList(result.data)
    }
    oracleDB()
    }, [])


  /* *************************************************  */
  // onchange 이벤트로 input 값 가져오기
  const onChange = (e) => {
    if(e.currentTarget == null) return;
  }


  /* ************************************************** */
  ////////////// 글등록 //////////////////

  const pointInsert = (e) => {
    
    e.preventDefault()
    const point_type = document.querySelector("#point_type").value;
    //console.log(point_type); /* 0~6 출력 decode 번호 */

    let list = {
        // json 형태로 spring에 값을 넘김
        member_no: parseInt(e.target.member_no.value),
        point_type: parseInt(point_type),
        point_used_saved: parseInt(e.target.point_used_saved.value),
    }
    // console.log(e.target.faq_category.value);
    console.log("pointInsert => "+ JSON.stringify(list));

    axios
    .post(process.env.REACT_APP_SPRING_IP +"point/pointinsert", list)
    .then((response) => {
      console.log(response);
      console.log(response.data);
      window.location.replace("/admin/point")
      alert("등록되었습니다!")
    })
    .catch((error) => {
        console.log(error);
    })
  }


    /* ************************************************** */
  /////////// 조건검색
  const dataSearch = (e) => {
    e.preventDefault()
    const gubun = document.querySelector("#gubun").value;
    const keyword = document.querySelector("#keyword").value;
    console.log(gubun+","+keyword);
    const asyncDB = async() => {
        const res = await pointlist({ gubun : gubun, keyword: keyword  })
        if(res.data){
            console.log(res.data);
            setPointList(res.data);
        }
    }
    asyncDB()
  };

  /* ************************************************** */
  // 새로고침
  const refresh = () => {
    window.location.reload();
  }


/* ************************************************** */



  return (
    <>
      <div className="container">

      <h4>적립금 수동 관리</h4>
      <hr />

        <Row>
          <Col xs={12} md={9}>
            <Row>
              <Col xs={12} md={8}>
                {/* ####################[[조건 검색]]############################## */}
                <div className="d-flex justify-content-baseline" style={{ width:"90%", height:"45px"}}>
                  <select id="gubun" name="gubun" className="form-select" aria-label="분류" style={{ width: "40%", marginRight: "10px" }}>
                    <option defaultValue>분류선택</option>
                    <option value="point_no">적립금번호</option>
                    <option value="member_no">회원번호</option>
                    <option value="point_type">적립/사용 내용</option>
                  </select>
                  <input type="text" id="keyword" name="keyword" className="form-control" placeholder="검색어를 입력하세요" />
                  <Button variant="outline-secondary" id="btn_search" style={{ marginLeft: "10px", width:"100px"}}
                          onClick={dataSearch}>
                    검색
                  </Button>
                  
                </div>
                {/* ###################[[조건검색 끝]]####################### */}
              </Col>
          
              <Col xs={6} md={4}>
                <div className="d-flex justify-content-end">
                  
                  <Button variant="outline-secondary" id="btn_search" style={{ marginRight: "20px", width:"120px"}}
                          onClick={refresh}>
                    <i className="fa-solid fa-arrows-rotate"></i>
                    &nbsp;새로고침
                  </Button>
                </div>
              </Col>
            </Row>

          <table>
            <colgroup>
              <col style={{ width: "11%" }} />
              <col style={{ width: "10%" }} />
              <col style={{ width: "10%" }} />
              <col style={{ width: "23%" }} />
              <col style={{ width: "13%" }} />
              <col style={{ width: "15%" }} />
              <col style={{ width: "18%" }} />
            </colgroup>

            <thead>
              <tr>
                <th>적립번호</th>
                <th style={{cursor:"pointer"}}>회원번호</th>
                <th>적용금액</th>
                <th style={{cursor:"pointer"}}>적립/사용 내용</th>
                <th style={{cursor:"pointer"}}>잔여적립금</th>
                <th style={{cursor:"pointer"}}>적용일자</th>
                <th>수정 / 삭제</th>
              </tr>
            </thead>

            <tbody>
              {
                pointList.slice(offset, offset + limit).map((point, i) => (
                  <PointRowAdmin key={i} point={point} i={i} />
                ))
              }
            </tbody>
          </table>


          <Pagination
            total={pointList.length}
            limit={limit}
            page={page}
            setPage={setPage}
          />

            </Col>

{/* ******************************************************************** */}

            <Col xs={6} md={3}>
              <div style={{borderLeft:"2px solid #e6e6e6", padding:"5px 20px"}}>
              <form id="f_board" onSubmit={pointInsert} encType="multipart/form-data">
        
                <Container>
                  <Form.Group className="mb-4 mt-3">
                    <h5 style={{marginBottom:"30px"}}>적립금 추가</h5> 
                    <Form.Label className="member_no">회원번호</Form.Label>
                    <Form.Control
                        type='text' id='member_no' name='member_no' size="lg" onChange={onChange} />
                  </Form.Group>
                  
                  <Form.Group className="mb-4">
                    <Form.Label className="m_label">적립/사용 내용</Form.Label>
                    <Form.Select aria-label="Default select example" size="lg"
                                  id="point_type" name="point_type" >
                        <option>내용 선택</option>
                        <option value="0">회원가입적립</option>
                        <option value="1">추천인기입</option>
                        <option value="2">주문적립</option>
                        <option value="3">상품후기등록</option>
                        <option value="4">베스트후기선정</option>
                        <option value="5">적립금사용</option>
                      </Form.Select>
                      <Form.Text className="text-muted">
                        &nbsp;적립금사용 ex) -2000
                      </Form.Text>
                  </Form.Group>
                  
                  <Form.Group className="mb-3">
                    <Form.Label className="point_used_saved">적용금액</Form.Label>
                    <Form.Control
                          type='text' id='point_used_saved' name='point_used_saved' size="lg" onChange={onChange} />
                  </Form.Group>
                </Container>
        
                <div className="d-flex justify-content-end" style={{ marginBottom:"20px" }}>
                  <BROWN_BTN type="submit">
                    저장
                  </BROWN_BTN>
                </div>
              </form>
              </div>
            </Col>
          </Row>

      </div>
    </>
  );
};

export default PointAdmin;