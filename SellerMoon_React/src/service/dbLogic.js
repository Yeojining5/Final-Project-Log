import axios from "axios"

export const noticelist = (params) => {
  return new Promise((resolve, reject) => {
    try{
      const response = axios({
        method : "get",
        url : process.env.REACT_APP_SPRING_IP + "notice/noticelist",
        params : params,
      })

      resolve(response)
        
    }catch(error) {
      reject(error)
    }
  })
}

export const faqlist = (params) => {
  return new Promise((resolve, reject) => {
    try{
      const response = axios({
        method : "get",
        url : process.env.REACT_APP_SPRING_IP + "faq/faqlist",
        params : params,
      })

      resolve(response)
        
    }catch(error) {
      reject(error)
    }
  })
}

export const pointlist = (params) => {
  return new Promise((resolve, reject) => {
    try{
      const response = axios({
        method : "get",
        url : process.env.REACT_APP_SPRING_IP + "point/pointlist",
        params : params,
      })

      resolve(response)
        
    }catch(error) {
      reject(error)
    }
  })
}



/*******************[[ Heera ]]**************** */

export const registerMember = (params) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: "post",
        url: process.env.REACT_APP_SPRING_IP + "monthlymoon/register",
        params: params,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};

/* ********************************************* */