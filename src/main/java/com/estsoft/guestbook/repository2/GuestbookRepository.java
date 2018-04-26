package com.estsoft.guestbook.repository2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estsoft.guestbook.domain.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long> {
	List<Guestbook> findAllByOrderByRegDateDesc();
}
