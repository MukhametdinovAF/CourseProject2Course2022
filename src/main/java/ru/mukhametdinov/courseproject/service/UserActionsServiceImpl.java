package ru.mukhametdinov.courseproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mukhametdinov.courseproject.entity.UserActions;
import ru.mukhametdinov.courseproject.repository.UserActionsRepository;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class UserActionsServiceImpl implements UserActionsService{
    private UserActionsRepository userActionsRepository;

    @Autowired
    public UserActionsServiceImpl(UserActionsRepository userActionsRepository) {
        this.userActionsRepository = userActionsRepository;
    }

    @Override
    public void savelog(String currentState) {

        Calendar calendar = new GregorianCalendar();
        UserActions userActions= new UserActions();
        userActions.setDate_actions(calendar.getTime().toString());
        userActions.setDescription(currentState);
        userActionsRepository.save(userActions);
    }
}
