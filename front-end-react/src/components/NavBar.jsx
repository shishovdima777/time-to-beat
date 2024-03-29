import {useNavigate} from "react-router-dom";

const NavBar = () => {

    const navigate = useNavigate();

    const handleClick = () => {
        localStorage.setItem('authToken', '');
        window.location.reload();
    }
    return(
        <nav className="bg-black p-4">
            <div className="container mx-auto flex items-center justify-between">
                {/* Logo */}
                <a href="/" className="text-white text-2xl font-bold">Your Logo</a>

                {/* Search Bar */}
                <div className="flex-1 ml-4">
                    <input
                        type="text"
                        placeholder="Search..."
                        className="w-full max-w-[600px] p-2 rounded-md border border-gray-300 focus:outline-none focus:border-blue-700"
                    />
                </div>

                {/* Login and Sign Up Links */}
                <div className="flex items-center space-x-4">
                    <a href="/auth/login" className="text-white">Login</a>
                    <a href="/signup" className="text-white">Sign Up</a>

                    { localStorage.getItem('authToken') ? (
                        <button onClick={handleClick} className="text-white">Log out</button>
                        ) : null
                    }
                </div>
            </div>
        </nav>
    );
}

export default NavBar;