import 'package:dokki/data/model/library/library_book_model.dart';
import 'package:dokki/data/repository/library_repository.dart';
import 'package:flutter/foundation.dart';

class LibraryProvider extends ChangeNotifier {
  final LibraryRepository _libraryRepository = LibraryRepository();
  bool isLoading = false;

  List<LibraryBookModel> libraryBooks = [];
  Map<String, dynamic> pageData = {};

  // GET : 서재 조회
  Future<void> getLibraryBooks({
    required int userId,
    required int page,
  }) async {
    isLoading = true;

    try {
      Map<String, dynamic> libraryData = await _libraryRepository
          .getLibraryBooksData(userId: userId, page: page);
      libraryBooks = libraryData['libraryBooks'];
      pageData = libraryData['pageData'];
    } finally {
      isLoading = false;
      notifyListeners();
    }
  }
}