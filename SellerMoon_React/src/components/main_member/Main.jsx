import React, { useEffect, useState } from 'react';
import EventAlert from './EventAlert';
import Header from './../Common/Header';
import { CONTAINER_TAB } from './../../styles/MainStyle';
import TabContent from './TabContent';
import SliderBanner from './SliderBanner';
import Footer from './../Common/Footer';


const Main = () => {

  let [ alert, setAlert ] = useState(true);

  /* navbar 위에 이벤트알림 Alert */
  useEffect(() => {
    let event = setTimeout(() => { setAlert(false) }, 10000)
    return () => {
      clearTimeout(event)
    } /* 컴포넌트 mount 시 1회만 실행하고 싶으면 이렇게! */
  }, [])

  return (
    <>
        {
          alert === true ?
          <>
            <EventAlert />
          </>
          : null
        }

        <Header />

        <SliderBanner />

        <CONTAINER_TAB>
          <TabContent />
        </CONTAINER_TAB>

        <Footer />
        
    </>
  );
};

export default Main;