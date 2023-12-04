import {useEffect, useState} from "react";
import Games from "../../components/Games.jsx";
import SignUp from "../SignUp/SignUp.jsx";
import NavBar from "../../components/NavBar.jsx";


const Home = () => {

    const [games, setGames] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080');
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                const result = await response.json();
                setGames(result);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        }
        fetchData();
    }, []);


    return (

        <div className="container mx-auto bg-blue-500 p-8 font-body">
            <h1 className="text-3xl font-bold text-white mb-6">Popular Games</h1>
                <Games games={games} />
        </div>
    );
}


export default Home