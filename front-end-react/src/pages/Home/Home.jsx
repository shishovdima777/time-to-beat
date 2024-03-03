import {useEffect, useState} from "react";
import Games from "../../components/Games.jsx";
import axios from "axios";



const Home = () => {

    const [games, setGames] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get('http://localhost:8080');
                setGames(response.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };
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