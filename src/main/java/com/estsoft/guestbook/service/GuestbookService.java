package com.estsoft.guestbook.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estsoft.guestbook.domain.Guestbook;
import com.estsoft.guestbook.repository2.GuestbookRepository;

@Service
@Transactional //service단에 달리는 것이 맞다 dao단에 달리면 트랜잭션화 하는 의미가 별로 없다. 
public class GuestbookService {
	
	@Autowired
	GuestbookRepository guestbookRepository;

	
	public List<Guestbook> getMessageList() {
		// return guestbookRepository.findAll(new Sort(Sort.Direction.DESC, "regDate"));
		return guestbookRepository.findAllByOrderByRegDateDesc();
	}
	
	public Boolean deleteMessage( Guestbook guestbook ) {
		guestbookRepository.delete( guestbook );
		return true;
		//return guestbookRepository.remove( guestbook );
	}
	
	public void insertMessage( Guestbook guestbook ) {
		guestbook.setRegDate( new Date() );
		guestbookRepository.save( guestbook );
	}
}
