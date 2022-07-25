import './style.css';
import {ReactComponent as Logo} from './logo.svg'
function Navbar(){
    return(
        <nav className="main-navbar">
            <Logo />
            <a className='logo-text' href='home'>Samuel's Delivery</a>
        </nav>
    )
}

export default Navbar