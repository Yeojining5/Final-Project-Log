import React from 'react';
import { useState, useEffect } from 'react';
import { myorder } from '../../../service/dbLogic';
import Footer from './../Common/Footer';
import Header from './../Common/Header';
import { CONTENTS } from './../../../styles/NoticeStyle';
import SidebarMypage from './../Common/SidebarMypage';
import NavbarMypage from './../Common/NavbarMypage';
import { OTABLE, OTH, P_STRONG } from './../../../styles/SubStyle';
import MyOrderRow from './MyOrderRow';

const MyOrder = ({ myPoint, no, isLogin, logout, mySubs }) => {

  /* ************************************************** */

  // 주문 리스트 가져오기 */

  const [orderList, setOrderList] = useState([]);

  useEffect(() => {
    const myOrder = async () => {
      await myorder({ member_no: no }).then((res) => {
        if (res.data === null) {
          return 0;
        } else {
          //console.log(res);
          console.log(res.data);
          setOrderList(res.data);
        }
      });
    };
    myOrder();
  }, [no]);
  /* **************************************************** */


  return (
    <>
    <Header isLogin={isLogin} logout={logout} />
          <div className="container">
            <CONTENTS className="row">
              <SidebarMypage />
              <div className="col-9">
                <div className="list-wrapper">
                  <NavbarMypage myPoint={myPoint} mySubs={mySubs} />



      <p style={{ fontSize: "1.4rem", fontWeight: "600" }}>
        주문배송조회
      </p>
      <OTABLE>
        <colgroup>
          <col style={{ width: "67%" }} />
          <col style={{ width: "15%" }} />
          <col style={{ width: "18%" }} />
        </colgroup>

        <thead>
          <tr>
            <OTH>상품정보</OTH>
            <OTH>배송비</OTH>
            <OTH>진행상태</OTH>
          </tr>
        </thead>

        <tbody>
          {
            orderList.map((order, i) => (
              <MyOrderRow key={i} order={order} />
            ))
          }
        </tbody>
      </OTABLE>




                  </div>{" "}
            {/* end of list-wrapper */}
          </div>{" "}
          {/* end of col */}
        </CONTENTS>
      </div>{" "}
      {/* end of container */}
      <Footer isLogin={isLogin} logout={logout} />
    </>
  );
};

export default MyOrder;