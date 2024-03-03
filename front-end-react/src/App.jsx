import './App.css'
import {
    Route,
    Routes
} from "react-router-dom";
import Home from "./pages/Home/Home.jsx";
import NavBar from "./components/NavBar.jsx";
import SignUp from "./pages/SignUp/SignUp.jsx";
import Login from "./pages/Login/Login.jsx";
import ForgotPassword from "./pages/ForgotPassword/ForgotPassword.jsx";
import Game from "./pages/Game/Game.jsx";
import SubmitTime from "./pages/SubmitTime/SubmitTime.jsx";
import User from "./pages/User/User.jsx";

const App = () => {
    return (
        <>
            <NavBar />
            <div>
                <Routes>
                    <Route path="" element={<Home /> }/>
                    <Route path="auth/login" element={<Login /> }/>
                    <Route path="/signup" element={<SignUp /> }/>
                    <Route path="/forgot-password" element={<ForgotPassword /> }/>
                    <Route path="/game" element={<Game/>}/>
                    <Route path="/game/submit-time" element={<SubmitTime />} />
                    <Route path="/user" element={<User/>}/>
                </Routes>
            </div>
        </>
       );
}

export default App


