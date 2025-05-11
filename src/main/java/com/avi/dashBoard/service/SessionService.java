//package com.avi.dashBoard.service;
//
//import com.avi.dashBoard.entity.User;
//import com.avi.dashBoard.repository.UserSessionRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//
//@Service
//public class SessionService {
//
//    private final UserSessionRepository userSessionRepository;
//
//    public SessionService(UserSessionRepository userSessionRepository) {
//        this.userSessionRepository = userSessionRepository;
//    }
//
//    /**
//     * Saves or updates user session ID when a user logs in.
//     * @param username User's username
//     * @param sessionId New session ID
//     */
//    @Transactional
//    public void saveOrUpdateSession(String username, String sessionId) {
//        Optional<User> existingSession = userSessionRepository.findByUsername(username);
//
//        if (existingSession.isPresent()) {
//        	User userSession = existingSession.get();
//            userSession.setSessionId(sessionId);  // Update session ID
//            userSessionRepository.save(userSession);
//        } else {
//        	User newUserSession = new User(username, sessionId);
//            userSessionRepository.save(newUserSession);
//        }
//    }
//
//    /**
//     * Retrieves the current session for a user.
//     * @param username User's username
//     * @return Optional<UserSession>
//     */
//    public Optional<User> getUserSession(String username) {
//        return userSessionRepository.findByUsername(username);
//    }
//
//    /**
//     * Invalidates a session when the user logs out or a new session is created.
//     * @param username User's username
//     */
//    @Transactional
//    public void invalidateSession(String username) {
//        userSessionRepository.findByUsername(username).ifPresent(userSessionRepository::delete);
//    }
//}
