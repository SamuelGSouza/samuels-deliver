import './style.css';

import { ReactComponent as YouTubeIcon } from './images/youtube.svg';
import { ReactComponent as LinkedinIcon } from './images/linkedin.svg';
import { ReactComponent as InstagramIcon } from './images/instagram.svg';


function Footer() {
	return (
		<footer className='main-footer'>
            App desenvolvido durante a 2ª ed. do evento Semana DevSuperior
			<div className='footer-icons'>
				<a href='https://www.youtube.com/' target='_new'> <YouTubeIcon /> </a>
				<a href='https://www.linkedin.com/in/samuelgsouza/' target='_new'> <LinkedinIcon /> </a>
				<a href='https://www.instagram.com/' target='_new'> <InstagramIcon /> </a>

			</div>
		</footer>
	);
}

export default Footer;