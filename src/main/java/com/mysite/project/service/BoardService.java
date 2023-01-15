package com.mysite.project.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.project.dto.BoardDto;
import com.mysite.project.dto.FileDto;
import com.mysite.project.dto.ReplySaveRequestDto;
import com.mysite.project.model.Board;
import com.mysite.project.model.Reply;
import com.mysite.project.model.User;
import com.mysite.project.repository.BoardRepository;
import com.mysite.project.repository.ReplyRepository;
import com.mysite.project.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	// 생성자 주입
	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	private final UserRepository userRepository;
	
	//글쓰기
	@Transactional
	public void saveForm(BoardDto boardDto, User user) { //title,content
		boardDto.setCount(0);// 조회수 강제로 넣음
		boardDto.setUser(user);
		boardRepository.save(boardDto.toEntity());
	}

	

	//글 목록리스트
	@Transactional(readOnly=true)
	public Page<Board> boardList(Pageable pageable) {	
		return boardRepository.findAll(pageable);
	}
	
	
	
	//글 상세보기, 댓글 추가
	@Transactional(readOnly=true)
	public Board boardView(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 상세보기실패: 아이디를 찾을 수 없습니다");
		});
	}
	
	
	@Transactional(readOnly = true)
	public Board findById(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 실패: 글번호를 찾을 수 없습니다!");
		});
	}
	
	//글수정
	@Transactional
	public void updateForm(int id, Board requestBoard) {
	// 글 수정할려면 영속화를 시켜야함
	Board board = boardRepository.findById(id).orElseThrow(()->{
		return new IllegalArgumentException("글 찾기실패: 아이디를 찾을 수 없습니다");
	});
	
	//영속화된 board
	board.setTitle(requestBoard.getTitle());
	board.setContent(requestBoard.getContent());
	//해당 함수로 종료시 Service가 종료, 트랜잭션이 종료. 이때 더티체킹
	//영속화되어있는 Board의 데이터가 달라졌기 때문에 더티체킹이 일어나면서 자동 업데이트가 된다.
	
	}
	
	
	//글삭제
	@Transactional
	public void boardDelete(int id) {
		boardRepository.deleteById(id);
	}
	
	//댓글 등록
	@Transactional
	public void replyForm(ReplySaveRequestDto replySaveRequestDto) {
		
		User user = userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(()->{
			return new IllegalArgumentException("댓글쓰기 실패: 유저Id를 찾을 수 없습니다.");
		});// 영속화 완료
		
		
		Board board = boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(()->{
			return new IllegalArgumentException("댓글쓰기 실패: 게시글Id를 찾을 수 없습니다.");
		});// 영속화 완료
		
		Reply reply = Reply.builder()
				.user(user)
				.board(board)
				.content(replySaveRequestDto.getContent())
				.build();
		
		replyRepository.save(reply); //디비에 저장
	}
	
	//댓글 삭제
	@Transactional
	public void replyDelete(int replyId) {
		replyRepository.deleteById(replyId);
	}



}
