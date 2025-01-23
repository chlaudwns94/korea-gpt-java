import { Route, Routes, useLocation } from "react-router-dom";
import IndexPage from "./pages/IndexPage/IndexPage";
import WritePage from "./pages/WritePage/WritePage";
import { Global } from "@emotion/react";
import { global } from "./styles/global";
import MainLayout from "./components/MainLayout/MainLayout";
import ListPage from "./pages/ListPage/ListPage";
import SignupPage from "./pages/SignupPage/SignupPage";
import SigninPage from "./pages/SigninPage/SigninPage";
import { useEffect, useState } from "react";
import axios from "axios";
import { useRecoilState } from "recoil";
import { authUserIdAtomState } from "./atoms/authAtom";
import { useQuery } from "react-query";

function App() {
  const [ userId, setUserId ] = useRecoilState(authUserIdAtomState);
  const location = useLocation();

  const authenticatedUser = async () => {
    return await axios.get("http://localhost:8080/servlet_study_war/api/authenticated", {
      headers: {
        "Authorization": `Bearer ${localStorage.getItem("AccessToken")}`,
      }
    });
  }

  const authenticatedUserQuery = useQuery(
    ["authenticatedUserQuery"], 
    authenticatedUser, 
    {
      onSuccess: (response) => {
        console.log(response);
        setUserId(response.data.body);
      },
      onError: (error) => {
        console.log(error);
        setUserId(0);
      },
      enabled: !!localStorage.getItem("AccessToken"),
    }
  );

  return (
    <>
      <Global styles={global} />

      <MainLayout>
        <Routes>
          <Route path="/" element={ <IndexPage /> } />
          <Route path="/write" element={ <WritePage /> } />
          <Route path="/list" element={ <ListPage /> } />
          <Route path="/signup" element={ <SignupPage /> } />
          <Route path="/signin" element={ <SigninPage /> } />
        </Routes>
      </MainLayout>
    </>
  );
}

export default App;