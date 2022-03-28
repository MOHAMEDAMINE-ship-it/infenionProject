package com.project.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.InvitationDao;
import com.project.entities.Invitation;
import com.project.services.InvitationService;
@Service 
@Transactional
public class InvitationServiceImpl implements InvitationService {
	@Autowired
	private InvitationDao dao;
	
	@Override
	public void add(Invitation invitation) { dao.save(invitation); }

	@Override
	public void update(Invitation invitation) { dao.save(invitation); }

	@Override
	public void delete(Long id) { dao.deleteById(id); }

	@Override
	public Optional<Invitation> find(Long id) { return dao.findById(id); }

	@Override
	public List<Invitation> findAll() { return  dao.findAll(); }
	
	@Override
	public Optional<Invitation> findInvitByStatus(boolean status) { return  dao.findByStatus(status); }
	@Override
	public List<Invitation> findInvitByEmailSentAndStatus(boolean emailSent, boolean status) { return  dao.findByEmailSentAndStatus(emailSent, status); }
	@Override
	public long countInvitByStatus(boolean status) { return  dao.countByStatus(status); }
	@Override
	public long countInvitByEmailSent(boolean emailSent) { return  dao.countByEmailSent(emailSent); }
	@Override
	public long countInvit() { return dao.count(); }
}
