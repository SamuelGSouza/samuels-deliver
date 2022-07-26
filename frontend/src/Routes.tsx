import { 
    BrowserRouter as Router,
    Route,
    Routes 
} from "react-router-dom"
    
import Home from './Home'
import Navbar from "./Navbar"
import Orders from "./Orders"


function AppRoutes() {
    return (
        <Router>
            <Navbar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/orders" element={<Orders />} />
            </Routes>
        </Router>
    )
}

export default AppRoutes